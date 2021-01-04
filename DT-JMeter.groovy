import org.apache.jmeter.protocol.http.control.Header;

def vu = ctx.getThreadGroup().getName() + "-" + ctx.getThreadNum();
def si = "JMeter" + org.apache.jmeter.util.JMeterUtils.getJMeterVersion();
def tsn = sampler.getName()
def ltn
def lsn

try {
	lsn = (args.length > 0) ? args[0] : "No name for Test Plan" //To Configure Test Plan name, add ${__TestPlanName} in Parameters as first argument
	ltn = vars.get("LoadTestName") ?: "No name for Load Test" //To Configure Load Test Name, add a variable `LoadTestName` and the value in Test Plan or User Defined Variables
	dtheaders = "SI=" + si + ";LSN="+ lsn + ";TSN=" + tsn + ";LTN=" + ltn + ";VU=" + vu + ";"
	sampler.headerManager.removeHeaderNamed('X-Dynatrace-Test')
	sampler.headerManager.add(new Header('X-Dynatrace-Test', dtheaders))
}
catch(Exception e) {
	log.info("Caught " + e) //Catching the exception
}