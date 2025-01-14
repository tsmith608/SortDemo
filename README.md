# Sorting Algorithm Performance Comparison

This project compares the performance of different sorting algorithms in Java. It generates random arrays of various sizes and measures the execution time for the following algorithms:
- Bubble Sort
- Quick Sort (using `Arrays.sort()`)
- Merge Sort
- Selection Sort
- Insertion Sort

The execution times for each algorithm are logged into a CSV file for further analysis.

## Introduction
Sorting is a fundamental operation in computer science, and there are many algorithms to accomplish it. This project aims to evaluate the performance of common sorting algorithms by measuring their execution time on randomly generated arrays of different sizes.

## Algorithms Implemented
The following sorting algorithms are implemented and tested:
- **Bubble Sort**: A simple comparison-based algorithm that repeatedly swaps adjacent elements if they are in the wrong order.
- **Quick Sort**: A divide-and-conquer algorithm that recursively partitions the array around a pivot element.
- **Merge Sort**: A divide-and-conquer algorithm that splits the array into smaller sub-arrays and merges them back together in sorted order.
- **Selection Sort**: A simple algorithm that finds the smallest element and swaps it with the first unsorted element.
- **Insertion Sort**: A simple algorithm that builds the sorted portion of the array by inserting elements one at a time.

## Performance Results
The performance of each sorting algorithm is measured by executing the algorithm on arrays of varying sizes (from 10 to 200,000 elements). The execution time is measured in milliseconds and logged in a CSV file for each algorithm.

## File Output
The results of the performance comparison are saved in the `output.csv` file. The file will contain the following structure:
- First, the name of the sorting algorithm (Bubble, Quick, Merge, etc.)
- Then, the execution times for various array sizes in milliseconds.
