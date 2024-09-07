var httpClient = new HttpClient();

var getCipherResponse =  httpClient.GetAsync("https://thecodingchallenge.com/.netlify/functions/challengeContent").Result;
var getCipherResult =  getCipherResponse.Content.ReadAsStringAsync().Result;
Console.WriteLine(getCipherResult);

var setAnswerResponse =  httpClient.GetAsync("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer=answer").Result;
var setAnswerResult = setAnswerResponse.Content.ReadAsStringAsync().Result;
Console.WriteLine(setAnswerResult);


// Connect to the API
// Read the message and key
// loop through the message to get each word
// loop through each word to get the letters
// lookup each letter in the key
// push to console
// push to answer url