const https = require("https");

const morseUrl = "https://thecodingchallenge.com/.netlify/functions/challengeContent";
const answerUrl = "https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer={answer}";

async function main() {
    try {
        const content = await fetchContent(morseUrl);
        console.log(content);

        const answerContent = await fetchContent(answerUrl);
        console.log(answerContent);

    } catch (error) {
        console.error("Error fetching content:", error);
    }
}

function fetchContent(url) {
    return new Promise((resolve, reject) => {
        https
            .get(url, (response) => {
                let data = "";

                response.on("end", () => {
                    resolve(data);
                });
            })
            .on("error", (error) => {
                reject(error);
            });
    });
}

function fetchContent(url) {
    return new Promise((resolve, reject) => {
        https
            .get(url, (response) => {
                let data = "";

                response.on("data", (chunk) => {
                    data += chunk;
                });

                response.on("end", () => {
                    resolve(data);
                });
            })
            .on("error", (error) => {
                reject(error);
            });
    });
}


main();