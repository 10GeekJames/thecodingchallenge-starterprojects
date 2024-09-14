use std::error::Error;

fn main() -> Result<(), Box<dyn Error>> {
    let get_cipher_response = reqwest::blocking::get("https://thecodingchallenge.com/.netlify/functions/challengeContent")?.text()?;
    println!("{:#?}", get_cipher_response);
    
    let answer: &str = "your answer";
    let set_answer_response = reqwest::blocking::get(format!("https://thecodingchallenge.com/.netlify/functions/challengeContentCheckAnswer?answer={answer}"))?.text()?;
    println!("{:#?}", set_answer_response);
    Ok(())
}