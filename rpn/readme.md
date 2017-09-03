# RPN Calculator Kata

[From dlresende gist](https://gist.github.com/dlresende/274194dd6ec993eb5ec5)

A RPN calculator program computes expressions written in RPN (Reverse Polish Notation). A RPN expression (or a postfix expression) is one of the following:

    a number X, in which case the value of the expression is that of X;
    a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an arithmetic operations; in this case, the value of the expression is that of E1 O E2

The following are RPN expressions:

    20 5 / => (20/5) = 4
    4 2 + 3 - => (4+2)-3 = 3
    3 5 8 * 7 + * => 3*((5*8)+7) = 141
    7 2 - 3 4 = 5 3 4

Suggested scenarios

    Given a RPN Calculator when a digit is sent it should display the same digit
    Given a RPN Calculator when some digits are sent it should display the number formed by those digits
    Given a RPN Calculator when an operations (* + / -) is sent after two numbers it should display the result of that operations


Trying to apply following rules :

* One level of indentation per method.
* Don't use the ELSE keyword.
* Wrap all primitives and Strings in classes.
* First class collections.
* One dot per line.
* Don't abbreviate.
* Keep all classes less than 50 lines.
* No classes with more than two instance variables.
* No getters or setters.
