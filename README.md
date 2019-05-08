# shrtn

> A Kotlin URL shortener experiment

The goal of this project was to create a very simple app using Kotlin, from the IDE to the cloud.

## The stack

- A Javelin server for routing
- Inspired by clean architecture
- Gradle
- Kotlin
- Docker
- Heroku

If you feel like the code could be more idiomatic then do not hesitate to create an issue :)

## Usage

```
# Shorten an URL
curl --request POST \
  --url https://url-shrtn.herokuapp.com/s \
  --header 'content-type: application/json' \
  --data '{\n	"url": "https://medium.com/@magnus.chatt/why-you-should-totally-switch-to-kotlin-c7bbde9e10d5"\n}'

# The service will respond with something like 
{
  "short": "https://url-shrtn.herokuapp.com/s/<LINK ID>"
}

# You can then visit the short URL and you'll be redirected to the original address.
```
