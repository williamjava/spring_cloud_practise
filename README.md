My practise on SpringCloud, based on SpringBoot.

It's easy for us to make a micro-service architecture using Spring Cloud.

Here we need to know that what's micro-service. Just make it easy, micro-service is a concept. Its purpose is to make a complicate application into many small services. Each service can be built,maintained and extended alone. In my opinion, it's awesome.

As we know, if we don't have Spring Cloud, I think it's not easy to make a micro-service architecture. But now it's easy for us to do it.

1. How to test presure performance?
use apache tool ab.
ab -c 5 -n 20 http://localhost:7777/add
