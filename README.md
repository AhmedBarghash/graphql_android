# graphql_android

Let’s explore how we can consume 
GraphQL API’s on Android. Although there are multiple client libraries for the web, 
so far there is only 1 GraphQL client for Android Apollo.

Apollo Android is an awesome GraphQL client that makes consuming GraphQL API easy. It has 2 main components
Apollo Codegen, this component is a gradle plugin to generate code like ButterKnife, apollo codegen generates 
Java models from standard graphql queries at compile time.

Networking/Caching, the other component of Apollo android is the networking and caching piece, 
this takes care of all the network communication with your GraphQL API, parsing the response to correct model,
enabling you to pass dynamic data to your GraphQL queries and response caching.
