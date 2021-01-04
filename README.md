# 🖇 Dynatrace JMeter Integration

This repo has a simple JMeter test plan and a groovy script to integrate JMeter with Dynatrace.

# 🙋‍♂️ How it works?

## Step 1
Add a `Pre Processor` element to your `Thread Group` and copy the [DT-JMeter.groovy](./DT-JMeter.groovy) to the Pre Processor.

## Step 2 (Optional)
* To configure Test Plan name, add `${__TestPlanName}` to the `Parameters` field in the `Pre Processor`.
* To configure Load Test name, add a variable `LoadTestName` either in `Test Plan` or `User Defined Variable` and its value.

## Step 3
Execute the test. Dynatrace headers will be added to each sampler and for each thread.

e.g. `X-Dynatrace-Test: SI=JMeter5.4;LSN=Dynatrace-Tagging.jmx;TSN=HTTP Request 1;LTN=No name for Load Test;VU=Thread Group-0;`

# 🙏 Inspired from
[this repo](https://github.com/grabnerandi/simplenodeservice)