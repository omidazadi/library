#!/bin/bash

printf "Testing..."
printf "\n------------------------------------------------------------------------\n"

printf "Reaching home.\n"
curl -X GET "http://localhost:8080/home"
printf "\n------------------------------------------------------------------------\n"

printf "Adding a book.\n"
curl -X POST -d "{\"title\": \"Basic Economics\", \"author\": \"Thomas Sowell\", \"price\": \"10.99f\", \"publicationDate\": \"2014-12-01\", \"description\": \"A citizen's guide to economics.\"}" -H "Content-type: application/json" "http://localhost:8080/book/add"
printf "\n------------------------------------------------------------------------\n"

printf "Adding a book.\n"
curl -X POST -d "{\"title\": \"My Book\", \"author\": \"Me\", \"price\": \"3.99f\", \"publicationDate\": \"2022-08-23\", \"description\": \"Yep.\"}" -H "Content-type: application/json" "http://localhost:8080/book/add"
printf "\n------------------------------------------------------------------------\n"

printf "Adding a book.\n"
curl -X POST -d "{\"title\": \"My Book\", \"author\": \"Me\", \"price\": \"3.99f\", \"publicationDate\": \"2022-08-23\", \"description\": \"Yep.\"}" -H "Content-type: application/json" "http://localhost:8080/book/add"
printf "\n------------------------------------------------------------------------\n"

printf "Updating a book.\n"
curl -X POST -d "{\"title\": \"Your Book\", \"author\": \"You\", \"description\": \"Nope.\"}" -H "Content-type: application/json" "http://localhost:8080/book/3/update"
printf "\n------------------------------------------------------------------------\n"

printf "Getting a book.\n"
curl -X GET "http://localhost:8080/book/1/show"
printf "\n------------------------------------------------------------------------\n"

printf "Getting all books.\n"
curl -X GET "http://localhost:8080/book/show"
printf "\n------------------------------------------------------------------------\n"

printf "Adding a member.\n"
curl -X POST -d "{\"name\": \"Gholi\", \"birthDate\": \"1957-03-10\", \"registrationDate\": \"2001-11-09\"}" -H "Content-type: application/json" "http://localhost:8080/member/add"
printf "\n------------------------------------------------------------------------\n"

printf "Adding a member.\n"
curl -X POST -d "{\"name\": \"Omid\", \"birthDate\": \"2001-07-09\", \"registrationDate\": \"2021-01-01\", \"bio\": \"Mighty me\"}" -H "Content-type: application/json" "http://localhost:8080/member/add"
printf "\n------------------------------------------------------------------------\n"

printf "A Member buys a book.\n"
curl -X POST -d "{\"acquirementDate\": \"2021-01-01\"}" -H "Content-type: application/json" "http://localhost:8080/member/1/acquire/book/1"
printf "\n------------------------------------------------------------------------\n"

printf "A Member buys a book.\n"
curl -X POST -d "{\"acquirementDate\": \"1523-01-01\"}" -H "Content-type: application/json" "http://localhost:8080/member/1/acquire/book/2"
printf "\n------------------------------------------------------------------------\n"

printf "A Member buys a book.\n"
curl -X POST -d "{\"acquirementDate\": \"1111-01-01\"}" -H "Content-type: application/json" "http://localhost:8080/member/2/acquire/book/2"
printf "\n------------------------------------------------------------------------\n"

printf "Get a member's library\n"
curl -X GET "http://localhost:8080/member/1/library"
printf "\n------------------------------------------------------------------------\n"

printf "Get a member's library\n"
curl -X GET "http://localhost:8080/member/2/library"
printf "\n------------------------------------------------------------------------\n"


