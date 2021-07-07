interface Tea {
  code: "T";
  price: 40;
}

interface Coffee {
  code: "C";
  price: 60;
}

interface Chocolate {
  code: "H";
  price: 50;
}

interface OrangeJuice {
  code: "O";
  price: 60;
}

interface Message {
  code: "M";
  content: string;
}

interface Command {
  code: string;
  price: number;
  sugars?: number;
  stick?: "0";
  extraHot?: "h";
  payed: true;
}

export interface DrinkMaker {
  handle: (command: string) => void;
}

interface Report {
  [code: string]: {
    numberSold: number;
    moneyEarned: number;
  };
}

export interface CoffeeMachine {
  handle: (command: Command | Message) => void;
  reports: Report;
}

export function requestDrink(name: "OrangeJuice"): OrangeJuice;
export function requestDrink(name: "Chocolate"): Chocolate;
export function requestDrink(name: "Coffee"): Coffee;
export function requestDrink(name: "Tea"): Tea;
export function requestDrink(
  name: "Tea" | "Coffee" | "Chocolate" | "OrangeJuice",
): Tea | Coffee | Chocolate | OrangeJuice {
  switch (name) {
    case "Tea":
      return { code: "T", price: 40 };
    case "Coffee":
      return { code: "C", price: 60 };
    case "Chocolate":
      return { code: "H", price: 50 };
    case "OrangeJuice":
      return { code: "O", price: 60 };
  }
}

export const addExtraHot = (drink: Tea | Coffee | Chocolate) => {
  return {
    ...drink,
    extraHot: "h",
  };
};

export const addSugar = (n: number) =>
  (drink: Tea | Coffee | Chocolate) => {
    return {
      ...drink,
      sugars: n,
      stick: n > 0 ? "0" : undefined,
    };
  };

export const pay = (amount: number) =>
  (drink: Tea | Coffee | Chocolate | OrangeJuice): Command | Message => {
    if (amount < drink.price) {
      return {
        code: "M",
        content: `Missing ${drink.price - amount} cents`,
      };
    }
    return {
      ...drink,
      payed: true,
    };
  };

const isMessage = (command: Command | Message): command is Message =>
  command.code === "M";

export const coffeeMachine = (drinkMaker: DrinkMaker): CoffeeMachine => {
  const reports: Report = {};
  return {
    reports,
    handle: (command: Command | Message) => {
      if (isMessage(command)) {
        drinkMaker.handle(`${command.code}:${command.content}`);
      } else {
        drinkMaker.handle(
          `${command.code}${command.extraHot ?? ""}:${command.sugars ??
            ""}:${command.stick ?? ""}`,
        );
        const { numberSold, moneyEarned } = reports[command.code] ??
          { numberSold: 0, moneyEarned: 0 };
        reports[command.code] = {
          numberSold: 1 + numberSold,
          moneyEarned: command.price + moneyEarned,
        };
      }
    },
  };
};

export function createCommand<T1, T2>(
  f: (x: T1) => T2,
  val: T1,
): T2;
export function createCommand<T1, T2, T3>(
  g: (x: T2) => T3,
  f: (x: T1) => T2,
  val: T1,
): T3;
export function createCommand<T1, T2, T3, T4>(
  h: (x: T3) => T4,
  g: (x: T2) => T3,
  f: (x: T1) => T2,
  val: T1,
): T4;
// deno-lint-ignore no-explicit-any
export function createCommand(...args: any[]) {
  const val = args.pop();
  return args.reduceRight((val, fn) => fn(val), val);
}
