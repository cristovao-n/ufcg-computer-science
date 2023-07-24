main :-
    read(List),
    read(Value),
    do_math_operations(List, Value, "plus"),
    halt.

calculate(A, B, Operation, Resultado) :-
    (Operation = "plus" -> Resultado is A + B;
    (Operation = "minus" -> Resultado is A - B;
    (Operation = "times" -> Resultado is A * B;
    (B =\= 0 -> Resultado is A / B; Resultado is A / 1)))).

do_math_operations([], A,_) :-
    write(A).

do_math_operations([Head|Tail], Value, Operation) :-
    (Operation = "plus" ->
        calculate(Value, Head, Operation, Resultado),
        do_math_operations(Tail, Resultado, "minus");
    Operation = "minus" ->
        calculate(Value, Head, Operation, Resultado),
        do_math_operations(Tail, Resultado, "times");
    Operation = "times" ->
        calculate(Value, Head, Operation, Resultado),
        do_math_operations(Tail, Resultado, "divided_by");
    calculate(Value, Head, Operation, Resultado),
    do_math_operations(Tail, Resultado, "plus")).
