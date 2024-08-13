local http = require("socket.http")
local API_URL = "https://thecodingchallenge.com/.netlify/functions/challengeContent"
local Response = http.request(API_URL)

-- local Answer = ""
-- local Result = HttpService:PostAsync(API_URL, Answer)