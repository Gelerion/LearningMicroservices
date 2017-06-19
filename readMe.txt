Every HTTP request is composed of a number of separate stages:
    DNS resolution, TCP connection handshake, TLS negotiation (if required),
    dispatch of the HTTP request, followed by content download

There are two important issues, the first one is connection-per-host, the second one is network latency:

 connection-per-host is a limit of how many connections are created to given origin simultaneously.
    "Origin: Combination of URI schema, domain name and port number.
        For instance, http://example.com:80 and https://example.com:443 are considered as different origins"
 each browser vendor has a different number, and currently, this number is between 4 and 13.

Head-of-line blocking:
 TCP offers in-order delivery of packages if one package is lost, the receiver must hold all subsequent packages
 in a buffer until the lost packet is retransmitted and arrives at the receiver. Which also means, while a browser
 is waiting for an available request to be completed it will block any other request to be responded, irrelevant of
 the size. If there are two HTTP requests on the same connection, the second response has to wait till the first
 one is completed. This is called head-of-line-blocking

 This limit applies per origin. Several years ago most browsers had the limit of 2 concurrent connection.
 However, over years, browser vendors had increased this number.

 HTTP 2 on the hand uses 1 TCP connection per origin and addresses this issue with multiplexing, which allows
 responses to arrive in any order. This allows making a concurrent request which responses arrives as they become
 available with only 1 open TCP connection per origin

Load balancing:
 * Traffic should be distributed evenly as possible
 * If one of the services is down, consumer should not make any request to failed service anymore
To implement this feature you might need:
 * List of IP addresses to create pool of resources
 * Health check mechanism to verify running or failing services
 * Health check frequency, how often health check should be made to update the resource pool
 * Strategy for load balancing that is how to distribute traffic(e.g. one after another, based on response time, etc.)