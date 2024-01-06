package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANIds;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBaseSubsystem extends SubsystemBase {
  // create your private TalonFXs
   /** Creates a new DrivebaseSubsystem. */
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;

  AnalogPotentiometer analogPotentiometer;
  
  // write your setPower methods
  public DriveBaseSubsystem() {
    left1 = new TalonFX(CANIds.leftFalcon1.id);
    left2 = new TalonFX(CANIds.leftFalcon2.id);
    right1 = new TalonFX(CANIds.rightFalcon1.id);
    right2 = new TalonFX(CANIds.rightFalcon2.id);

    analogPotentiometer  = new AnalogPotentiometer(0, 300, 0);

    factoryResetAll();
    
    left2.follow(left1);
    right2.follow(right1);
  }

  public void coast() {
    left1.setNeutralMode(NeutralMode.Coast);
    left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    right2.setNeutralMode(NeutralMode.Coast);
  }

  public void brake() {
    left1.setNeutralMode(NeutralMode.Brake);
    left2.setNeutralMode(NeutralMode.Brake);
    right1.setNeutralMode(NeutralMode.Brake);
    right2.setNeutralMode(NeutralMode.Brake); 
  }

  public void factoryResetAll() {
    left1.configFactoryDefault();
    left2.configFactoryDefault();
    right1.configFactoryDefault();
    right2.configFactoryDefault();
  }


  public void setLeftRightPower(double powerLeft, double powerRight) {
    left1.set(ControlMode.PercentOutput, powerLeft);
    left2.set(ControlMode.PercentOutput, powerLeft);
    right1.set(ControlMode.PercentOutput, powerRight);
    right2.set(ControlMode.PercentOutput, powerRight);
  }

  public double getDistance() {
    SmartDashboard.putNumber("Distance", analogPotentiometer.get());
    System.out.println(analogPotentiometer.get());
    return analogPotentiometer.get();
  }
  
  @Override
  public void periodic() {
    
  }
  
}
