/**
 * 
 */
package de.charite.compbio.simdrom.sampler.vcf;

import htsjdk.variant.vcf.VCFFileReader;

import java.io.File;
import java.util.List;
import java.util.Random;

/**
 * @author Max Schubach {@literal <max.schubach@charite.de>}
 *
 */
public class VCFRandomSampleSelecter {

	private VCFFileReader parser;
	private String sample;

	public VCFRandomSampleSelecter(String filePath) {
		this.parser = new VCFFileReader(new File(filePath), false);
	}

	public VCFRandomSampleSelecter(String filePath, String sample) {
		this(filePath);
		this.sample = sample;
	}

	public String getSample() {
		if (sample == null)
			sample = selectSample();
		return sample;
	}
	
	private String selectSample() {
		List<String> samples =  parser.getFileHeader().getGenotypeSamples();
		parser.close();
		int num = new Random().nextInt(samples.size());
		return samples.get(num);
	}


}
