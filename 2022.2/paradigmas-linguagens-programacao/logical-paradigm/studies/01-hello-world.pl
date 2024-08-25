loves(albert, alice).

loves(alice, albert) :- loves(albert, alice).

% facts
happy(albert).
happy(alice).
happy(bob).
happy(bill).

% rules

dances(alice) :-
  happy(alice),
  loves(alice, X).

dances(X) :-
  happy(X),
  loves(Y, X).

parent(albert, bob).
parent(albert, betsy).
parent(albert, bill).

parent(alice, bob).
parent(alice, betsy).
parent(alice, bill).

parent(bob, carl).
parent(bob, charlie).

getGrandchild(X) :-
  parent(X, Y),
  parent(Y, Z),
  write(X),
  nl,
  write(Z).