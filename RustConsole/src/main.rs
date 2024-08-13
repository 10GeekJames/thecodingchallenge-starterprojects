use std::error::Error;

fn main() -> Result<(), Box<dyn Error>> {
    let getCipherResponse = reqwest::blocking::get("https://thecodingchallenge.com/.netlify/functions/challengeContent")?.text()?;
    println!("{:#?}", getCipherResponse);
    
    let answer: &str = "your answer";
    let setAnswerResponse = reqwest::blocking::get(format!("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer={answer}"))?.text()?;
    println!("{:#?}", setAnswerResponse);
    Ok(())
}