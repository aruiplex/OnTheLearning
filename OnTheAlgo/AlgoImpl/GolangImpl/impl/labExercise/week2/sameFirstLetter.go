package impl

import "strings"

/*

Given a list of non-empty strings, write a method that returns a Map<String, String> with a key for every different first letter seen, with the value of all the strings starting with that letter appended with a comma (,) together in the order they appear in the list.

Test case 1:
sameFirstLetter(["alice", "bob", "apple", "banana"]) →  {"a": "alice,apple", "b": "bob,banana"}

Test case 2:
sameFirstLetter(["after", "all", "this", "time", "always"]) →  {"a":"after,all,always", "t": "this,time"}

*/
func sameFirstLetter(arr []string) map[string]string {
	m := map[string]string{}
	for i := 0; i < len(arr); i++ {
		word := arr[i]
		// v := m[string(word[1])]
		k := string(word[0:1])
		m[k] += word + ","
	}

	for k, v := range m {
		m[k] = strings.Trim(v, ",")
	}

	return m
}
