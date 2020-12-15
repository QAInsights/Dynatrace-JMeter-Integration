import org.apache.jmeter.protocol.http.control.Header;
import groovy.json.JsonSlurper

log.info("Number of parameters: " + args.length);
log.info("Parameters array: " + Parameters);

def x = formHeader(args.toString())
sampler.getHeaderManager().add(new Header("X-Dynatrace-Test",x));


def formHeader(id){
	log.info("Inside " + id.split(',')[0])
	def threadgroupname = id.split(',')[0]
	def threadnum = id.split(',')[1]
	def samplername = id.split(',')[2]
	header = "SI=" + threadgroupname + ";SN=" + threadnum + "; TE=" + samplername
	header = header.replace("[","")
	header = header.replace("]","")
	log.info(header)
	return header
	
}
