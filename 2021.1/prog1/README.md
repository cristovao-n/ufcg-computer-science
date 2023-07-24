## Arrays

The main difference between lists and arrays, is that we can't modify the structure, in other words, the length of the array. So we cannot use methods like pop or append, because these methods change the length of the list

\*Note: Python doesn't have a native array data structure. But we can simulate it with lists, to do that we just need to be aware of the arrays API and don't do anything beyond that.

That's the API for arrays:

- Create array with a fixed length

`array = [None] * 10`
`zeros_array = [0] * 3`

print(array): `[None, None, None, None, None, None, None, None, None, None]`
print(zeros_array): `[0, 0, 0]`

- Assign a value in a given index of the array

`array[2] = 100`

- Access an element of the array

`element = array[2]`

print(element): `100`

Really, that's it, there's nothing else.

So we can assign a value in a given position, and that's all! If we need to add or remove values based on the index, in the end, at the start, order the array, or anything dinamic like that, we should implement our own methods, and be aware of the case where the final length of the array is greater than the maximum length, defined initially.

In this project You'll find some functions and sort strategies for arrays and resolve some questions.

### insertion Sort
