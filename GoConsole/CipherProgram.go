package main
import (
	"fmt"
    "net/http"
    "io/ioutil"
)
func main() {
    getCipherResponse, _ := http.Get("https://thecodingchallenge.com/.netlify/functions/challengeContent")
    cipherBody, _ := ioutil.ReadAll(getCipherResponse.Body)
	fmt.Printf("ciper: response body: %s\n", cipherBody)

    setCipherAnswerResponse, _ := http.Get("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer=YourAnswerHere")
    cipherAnswerBody, _ := ioutil.ReadAll(setCipherAnswerResponse.Body)
	fmt.Printf("answer: response body: %s\n", cipherAnswerBody)
}