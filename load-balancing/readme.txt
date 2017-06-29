So we have a rough idea or expectation that RecoEngine can time to time response slowly,
but we do not know when this will happen, hence other services can also consume the same
resource. Hystrix, however, can do this job for us by monitoring each request and failing methods.
Be aware that there is a threshold. Hystrix than decides to open the circuit, while the circuit is
open and subsequent calls fail, but constantly open circuit is useless, so after while circuit
closes again, which means any request will be routed to the destination. It is, however, your
responsibility to identify the right threshold.

To encapsulate this process we need to move the risky operation to another class,
hence @HystrixCommand only works in classes that are annotated with @Service or @Component annotations.