# WORDLE Algorithm
This is matching algorithm of WORDLE game. You can implement the algorithm to build your desired application.

## Basic Usage

### JavaScript
```js
import {Wordle} from './wordle'

Wordle(guess, solution)
```

### PHP
```php
include('wordle.php')

Wordle($guess, $solution)
```

### Python
```py
from 'wordle' import Wordle

Wordle(guess, solution)
```

### C#
```cs
// Import namespace or Include to your class

Wordle.Wordle(guess, solution)
```

### Java
```java
// Import or Include to your class
wordle.Wordle(guess,solution)
```

### Go
```go
// Import or Include to your class
Wordle("agshs","sdsds")
```

## Return Type
Returns an `Array`/`String[]` of the status of each letter of the guessed word comparing to the solution word.
- `"correct"` : The letter is in correct position
- `"present"` : The letter is in present in the word, but not in position
- `"absent"` : The letter is in absent in the word

  
Example return:
`["absent", "present", "correct", "present", "absent"]`

--------------------------

## Wordle Game (ReactJS + Firebase)
- [[Github] https://github.com/dgvai/wordle-with-friends](https://github.com/dgvai/wordle-with-friends)