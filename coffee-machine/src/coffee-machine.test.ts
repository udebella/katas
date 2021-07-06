import { beforeEach, describe, expect, it, mock } from "./deps.test.ts";
import {
  addExtraHot,
  addSugar,
  CoffeeMachine,
  coffeeMachine,
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
    const tea = pay(50, addSugar(1, requestDrink("Tea")));

    machine.handle(tea);

    expect(drinkMaker.handle).toHaveBeenCalledWith("T:1:0");
  });

  it("sends the right command for chocolate", () => {
    const chocolate = pay(50, requestDrink("Chocolate"));

    machine.handle(chocolate);

    expect(drinkMaker.handle).toHaveBeenCalledWith("H::");
  });

  it("sends the right command for coffee", () => {
    const coffee = pay(60, addSugar(2, requestDrink("Coffee")));

    machine.handle(coffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("C:2:0");
  });

  it("displays missing amount", () => {
    const coffee = pay(50, addSugar(2, requestDrink("Coffee")));

    machine.handle(coffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("M:Missing 10 cents");
  });

  it("sends the right command for orange juice", () => {
    const orangeJuice = pay(60, requestDrink("OrangeJuice"));

    machine.handle(orangeJuice);

    expect(drinkMaker.handle).toHaveBeenCalledWith("O::");
  });

  it("sends the right command for extra hot coffee", () => {
    const extraHotcoffee = pay(60, addExtraHot(requestDrink("Coffee")));

    machine.handle(extraHotcoffee);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Ch::");
  });

  it("sends the right command for extra hot chocolate", () => {
    const extraHotchocolate = pay(
      50,
      addSugar(1, addExtraHot(requestDrink("Chocolate"))),
    );

    machine.handle(extraHotchocolate);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Hh:1:0");
  });

  it("sends the right command for extra hot tea", () => {
    const extraHotTea = pay(50, addExtraHot(addSugar(2, requestDrink("Tea"))));

    machine.handle(extraHotTea);

    expect(drinkMaker.handle).toHaveBeenCalledWith("Th:2:0");
  });

  it("displays report about earned money", () => {
    const extraHotTea = pay(50, addExtraHot(addSugar(2, requestDrink("Tea"))));

    machine.handle(extraHotTea);
    machine.handle(extraHotTea);

    expect(machine.reports).toEqual({ T: { numberSold: 2, moneyEarned: 80 } });
  });
});
