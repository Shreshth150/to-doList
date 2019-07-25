# To-do List Project (WIP)

This is a hobby project which consists of an API REST Spring Boot based project.

I made this project firstly for training myself on new Java features like lambdas as well as for NoSQL database systems and Docker too.

In this case, I chose Cassandra DB for storing data.

## Features Status

- [x] CRUD operations for a to-do list project.
- [x] Support for Cassandra.
- [x] Aspect for logging public controller methods.
- [x] Controller advice for handling controller exceptions.
- [ ] Request collection validation.
- [ ] Unit tests.
- [ ] Authorization.
- [ ] Support for Redis.
- [ ] Support for MongoDB.
- [ ] Support for MariaDB.

## API Operations

The following is a list of supported operations:
- Save a to-do item:`POST /todoList/items`
- Save a collection of to-do item:`POST /todoList/items/bulk`
- Delete a to-do item:`DELETE /todoList/items/{id}`
- Delete all to-do items:`DELETE /todoList/items`
- Retrieve all to-do items:`GET /todoList/items
- Update a to-do item:`PATCH /todoList/items`

## Examples

### Save item

Used to persist a to-do item on database.

**URL:** `/todoList/items`

**Method:** `POST.`

**Auth required:** No.

**Data constraints:**

```json
{
	"id": "[Valid number value, different for each item (WIP to avoid sending this parameter)]",
	"description": "[Valid text, not null or empty]"
}
```

**Data example:**

```json
{
	"id": 1,
	"description": "To do item example"
}
```

#### Success response

**Code:** `201 created.`

**Content:** No.

#### Error response

**Code:** `400 bad request.`

**Condition:** If 'id' or 'description' are null or empty.

**Content:**

```json
[
    "Id can not be null",
    "Description can not be null or empty"
]
```

### Save an items collection

Used to persist a to-do items collection on database.

**URL:** `/todoList/items/bulk`

**Method:** `POST.`

**Auth required:** No.

**Data constraints:**

```json
[
  {
    "id": "[Valid number value, different for each item (WIP to avoid sending this parameter)]",
    "description": "[Valid text, not null or empty]"
  },
  {
    "id": "[Valid number value, different for each item (WIP to avoid sending this parameter)]",
    "description": "[Valid text, not null or empty]"
  },
  ...
]
```

**Data example:**

```json
[
  {
    "id": 1,
		"description": "To do item example"
	},
  {
    "id": 2,
		"description": "To do item example 2"
	}
]
```

#### Success response

**Code:** `201 created.`

**Content:** No.

#### Error response (WIP)

**Code:**

**Condition:**

**Content:** No.

### Delete item

Used to delete a specific to-do item on database.

**URL:** `/todoList/items/{id}`

**Method:** `DELETE.`

**Auth required:** No.

**Data constraints:**

```json
{id} must be a valid number and a persisted object has to have it as id.
```

**Data example:**

```
/todoList/items/1
```

#### Success response

**Code:** `204 no-content.`

**Content:** No.

#### Error response (WIP)

**Code:**

**Condition:**

**Content:**

```json

```

### Delete all items

Used to delete all to-do items saved on database.

**URL:** `/todoList/items`

**Method:** `DELETE.`

**Auth required:** No.

**Data constraints:** No.

**Data example:** No.

#### Success response

**Code:** `204 no-content.`

**Content:** No.

#### Error response (WIP)

**Code:**

**Condition:**

**Content:**

```json

```

### Retrieve all items

Used to retrieve all to-do items on database.

**URL:** `/todoList/items`

**Method:** `GET.`

**Auth required:** No.

**Data constraints:** No.

#### Success response

**Code:** `200 ok.`

**Content:** A Page object.

```json
{
    "content": [
        {
            "id": 1,
            "description": "To do item example",
            "createdDatetime": "2019 26 25 11:07:03"
        },
        {
            "id": 2,
            "description": "To do item example 2",
            "createdDatetime": "2019 57 25 11:07:49"
        }
    ],
    "pageable": "INSTANCE",
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "size": 0,
    "number": 0,
    "sort": {
        "sorted": false,
        "unsorted": true,
        "empty": true
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
}
```

#### Error response (WIP)

**Code:**`

**Condition:**

**Content:**

```json

```

### Update item

Used to update a to-do item saved on database.

**URL:** `/todoList/items`

**Method:** `PATCH.`

**Auth required:** No.

**Data constraints:**

```json
{
	"id": "[Valid number value, unique for each item]",
	"description": "[Valid text, not null or empty]"
}
```

**Data example:**

```json
{
	"id": 1,
	"description": "New description for to-do item with id = 1"
}
```

#### Success response

**Code:** `204 no-content.`

**Content:** No.

#### Error response (WIP)

**Code:**`

**Condition:**

**Content:**

```json

```

## Technologies

This project uses the following technologies:
- Java.
- Spring Boot.
- Maven.
- Cassandra DB.
- Docker.

## Tools

This project was made using the following tools:

- [IntelliJ IDEA](https://www.jetbrains.com/idea).
- [Gitignore.io](https://www.gitignore.io).
- [Typora](https://typora.io).
- [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0-beta.4).
- [Postman](https://www.getpostman.com/).

## License

[GNU GPL 3.0](./LICENSE)