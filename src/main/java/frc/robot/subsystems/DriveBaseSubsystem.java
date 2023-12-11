package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class DriveBaseSubsystem extends SubsystemBase {
  private TalonFX motor;
  public DriveBaseSubsystem() {
    motor = new TalonFX(50);
  }
  @Override
  public void periodic() {
  }
  public void coast(){
    motor.setNeutralMode(NeutralMode.Coast);
  }
    public void brake(){
      motor.setNeutralMode(NeutralMode.Brake);
    }
  public void setPower(double power){
    motor.set(ControlMode.PercentOutput, power);
  }
}