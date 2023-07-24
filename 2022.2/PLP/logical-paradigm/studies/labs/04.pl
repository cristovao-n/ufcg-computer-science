maior_posicao(Matriz, Posicao) :-
    flatten(Matriz, Lista),
    max_list(Lista, Maior),
    nth1(PosLinha, Matriz, Linha),
    nth1(PosColuna, Linha, Maior),
    Posicao = [PosLinha, PosColuna].

main :-
    read(Matriz),
    maior_posicao(Matriz, Posicao),
    write(Posicao).
    