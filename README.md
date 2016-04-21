### Alang

#### About

Simple procedural language.

Examples of source code can be found in `progs` and `test-programs` dirs.

Let's look at some example:

```c
int callCounter;

int power(int n, int k) { // n^k
    callCounter = callCounter + 1;
    int r;
    r = 1;
    while (k > 0) {
        if (k % 2 == 1) {
            r = r * n;
        } else {
        }
        n = n * n;
        k = k / 2;
    }
    return r;
}

void main() {
    while(f) {
        int n;
        int k;
        read(n);
        read(k);
        if (n == -1 && k == -1) {
            print(callCounter);
            break;
        } else {
            print(power(n, k));
        }
    }
}
```

Some details:

1. The language has `void`, `int`, `bool` types
2. There are only global var declarations and function declarations at top level. Global vars go first.
2. Entry point - `main` function
3. `else` branch in `if` is required
4. `break` and `continue` are supported in `while` loop
5. `switch` statement has unusal syntax
```
        switch (x) {
            1 : { print(20); }
            2 : { print(40); }
            3 : { print(60); }
            4 : { print(80); }
            5 : { print(100); }
            default : { print(0); break; }
        }
```
7.


#### Tests
There are some unit tests in `src/test` directory


#### Run
After setup project in IDEA (build systems are not supported now)
You can compile and run program by calling `Compiler program-file`