package frc.robot.subsystems;

import com.revrobotics.AnalogInput;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensorSubsystem extends SubsystemBase {
  // create your private AnalogPotentiometer instance variable
  AnalogPotentiometer pot = new AnalogPotentiometer(0,180,30);
  public DistanceSensorSubsystem() {
    // instantiate your sensor

  }
  
  // make a getDistance method
  public double getDistance(){
    double distance = pot.get();
    return distance;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
