package main

import (
	"fmt"

	impl "aruix.net/code/algo/impl/everyDayProblems"
)

func main() {
	s := impl.ConstructorMyHashMap()
	s.Put(3, 4)
	s.Put(3, 5)
	fmt.Println(s.Get(3))
}
