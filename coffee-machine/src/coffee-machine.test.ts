import { beforeEach, describe, expect, it, mock } from "./deps.test.ts";
import {
  addExtraHot,
  addSugar,
  CoffeeMachine,
  coffeeMachine,
  createCommand,
  DrinkMaker,
  pay,
  requestDrink,
} from "./cofee-machine.ts";

describe("coffee machine", () => {
  let machine: CoffeeMachine, drinkMaker: DrinkMaker;
  beforeEach(() => {
    drinkMaker = { handle: mock.fn() };
    machine = coffeeMachine(drinkMaker);
  });

  it("sends the right command for tea", () => {
    const tea = createCommand(
      requestDrink("Tea"),
      addSugar(1),
      pay(50),
    );

    machine.handle(tea);

    expect(drinkMaker.handle).toHaveBeenCalledWith("T:1:0");
  });

  it("sends the right command for chocolate", () => {
    const chocolate = createCommand(
      requestDrink("Chocolate"),
      pay(50),
    );

    machine.handle(chocolate);

    expect(drinkMaker.handle).toHaveBeenCalledWith("H::");
  });

  it("sends the right command for coffee", () => {
    const coffee = createCommand(
      requestDrink("Coffee"),
      addSugar(2),
      pay(60),
    );

    machine.handle(coffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("C:2:0");
  });

  it("displays missing amount", () => {
    const coffee = createCommand(
      requestDrink("Coffee"),
      addSugar(2),
      pay(50),
    );

    machine.handle(coffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("M:Missing 10 cents");
  });

  it("sends the right command for orange juice", () => {
    const orangeJuice = createCommand(
      requestDrink("OrangeJuice"),
      pay(60),
    );

    machine.handle(orangeJuice);

    expect(drinkMaker.handle).toHaveBeenCalledWith("O::");
  });

  it("sends the right command for extra hot coffee", () => {
    const extraHotcoffee = createCommand(
      requestDrink("Coffee"),
      addExtraHot,
      pay(60),
    );

    machine.handle(extraHotcoffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Ch::");
  });

  it("sends the right command for extra hot chocolate", () => {
    const extraHotchocolate = createCommand(
      requestDrink("Chocolate"),
      addExtraHot,
      addSugar(1),
      pay(50),
    );

    machine.handle(extraHotchocolate);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Hh:1:0");
  });

  it("sends the right command for extra hot tea", () => {
    const extraHotTea = createCommand(
      requestDrink("Tea"),
      addSugar(2),
      addExtraHot,
      pay(50),
    );

    machine.handle(extraHotTea);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Th:2:0");
  });

  it("displays report about earned money", () => {
    const extraHotTea = createCommand(
      requestDrink("Tea"),
      addSugar(2),
      addExtraHot,
      pay(50),
    );

    machine.handle(extraHotTea);
    machine.handle(extraHotTea);

    expect(machine.reports).toEqual({ T: { numberSold: 2, moneyEarned: 80 } });
  });
});
