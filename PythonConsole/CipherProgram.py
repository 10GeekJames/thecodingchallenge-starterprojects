import requests
import json

api_url = "https://thecodingchallenge.com/.netlify/functions/challengeContent"
response = requests.get(api_url)
print(response)

api_url_answer = "https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer="
response_answer = requests.get(api_url_answer + "answer")
print(response_answer)
