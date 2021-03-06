import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SecondPhaseSlider extends JSlider {
	public static final int MULTIPLIER = 10000;
	
	public SecondPhaseSlider(JLabel sliderValLabel, SineWave wave) {
		this.setMinimum(0 * MULTIPLIER);
		this.setMaximum((int) (2 * Math.PI * MULTIPLIER));
		this.setValue(0 * MULTIPLIER);
		this.setPreferredSize(new Dimension(200, 20));
		sliderValLabel.setText(String.valueOf(this.getValue()/MULTIPLIER));

		
		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				double val = ((SecondPhaseSlider)e.getSource()).getValue() * 1.0 / MULTIPLIER;
				sliderValLabel.setText(String.valueOf(val));
				wave.setSecondPhase(val);
				wave.calcSineVals();
			}
		});
	}
}
