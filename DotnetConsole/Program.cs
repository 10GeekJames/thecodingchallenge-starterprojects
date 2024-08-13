Task.Run(async () => {
    using(HttpClient httpClient = new HttpClient())
    {
        var getCipherResponse =  await (await httpClient.GetAsync("https://thecodingchallenge.com/.netlify/functions/challengeContent")).Content.ReadAsStringAsync();
        Console.WriteLine(getCipherResponse);

        var setAnswerResponse =  await (await httpClient.GetAsync("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer=answer")).Content.ReadAsStringAsync();
        Console.WriteLine(setAnswerResponse);
    }
}).Wait();