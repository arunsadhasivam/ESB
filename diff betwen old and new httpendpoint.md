Difference between old and new Http Endpoint
============================================
Mule 5.4 version:
===================
<http:request-config name="HTTP_request_Configuration" host="localhost"
port="8081"/>
<flow name="test_flow">
    <...>
    <http:request config-ref="HTTP_request_Configuration" path="/" method="GET" doc:name="NEW HTTP Connector"/>
</flow>

 before Mule 3.7 version:
 ========================
<flow name="test_flow">
    <...>
    <http:outbound-endpoint exchange-pattern="request-response" host="localhost" port="8081" method="GET" doc:name="OLD HTTP Connector"/>
</flow>




A key difference between the old HTTP connector and the new one is that – while the old connector listens by default to all subpaths below the one you define – the new HTTP Connector only listens to the specific path you define.

If you wish the new connector to accept subpaths, you can end the path with a wildcard (*)
