package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.CANIds.*;

public class DriveBaseSubsystem extends SubsystemBase {
  // create your private TalonFXs
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;
  public DriveBaseSubsystem() {
    // initialize da motors with CANIds from Constants.java
    left1 = new TalonFX(leftFalcon1.id);
    left2 = new TalonFX(leftFalcon2.id);
    right1 = new TalonFX(rightFalcon1.id);
    right2 = new TalonFX(rightFalcon2.id);

    left1.setInverted(true);
    left2.setInverted(true);
  }
  
  // write your setPower methods
  public void setLeftPower(double power) {
    left1.set(ControlMode.PercentOutput, power);
    left2.set(ControlMode.PercentOutput, power);
  }

  public void setRightPower(double power) {
    right1.set(ControlMode.PercentOutput, power);
    right2.set(ControlMode.PercentOutput, power);
  }

  public void setAllPower(double power) {
    setLeftPower(power);
    setRightPower(power);
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

  @Override
  public void periodic() {}
}
