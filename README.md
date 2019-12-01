# spring-boot-feign-demo

## How to try?
1. Run both (api - port 8098 & client - port 8099) modules
2. The `Api module` has `BootstrapClass` and there there is a creating simple data so the `Client module` can use them.
3. The `Api module` has CQRS design style
4. An API of the `Client module` is available via Swagger: http://localhost:8099/swagger-ui.html