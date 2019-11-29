# spring-boot-feign-demo

## How to try?
1. Run both (api - port 8098 & client - port 8099) modules
2. The `Api module` has `BootstrapClass` and there there is a creating simple data so the `Client module` can use them.
3. The `Client module` has endpoint http://localhost:8099/library/books/all and uses the ***Feign*** framework to call the `Api module` endpoint to
 receive data
4. The `Api module` has CQRS design style