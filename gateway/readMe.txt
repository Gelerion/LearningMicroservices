API Gateway provides a simplified interface to a larger system.
This simplified interface can manage several things:
    * Reduce the number of HTTP calls that are made to system, by merging resources internally
    * Provide different type of data based on client(e.g. desktop, mobile)
    * Add additional features easily, hence there is 1 gateway (e.g. API Throttling)
    * Act as a wrapper for poorly designed APIs with a single well-designed API
    * Simplified authentication for other services
    * Capability of connecting to different protocols (e.g. AMQP)


Routing(in this case) simply refers to forwarding client traffic to particular service.
The approach (reverse-proxy) is valid but if you need some extra processing for each HTTP request
(e.g. authentication, caching, rate-limiting) using pure HTTP reverse proxy will be very challenging.

Zuul filters can perform required authentication, debugging, routing and will enable you to add new HTTP endpoint
to the API Gateway is just a matter of couple lines of configuration.