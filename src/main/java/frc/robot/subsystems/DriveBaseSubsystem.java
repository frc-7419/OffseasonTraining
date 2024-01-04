package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {

    private TalonFX frontLeftMotor;
    private TalonFX rearLeftMotor;
    private TalonFX frontRightMotor;
    private TalonFX rearRightMotor;

    public DriveBaseSubsystem() {
        frontLeftMotor = new TalonFX(Constants.CANIds.leftFalcon1.id);
        rearLeftMotor = new TalonFX(Constants.CANIds.leftFalcon2.id);
        frontRightMotor = new TalonFX(Constants.CANIds.rightFalcon1.id);
        rearRightMotor = new TalonFX(Constants.CANIds.rightFalcon2.id);

        frontLeftMotor.setInverted(true);
        rearLeftMotor.setInverted(true);
        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);
    }

    public void setPower(double leftPower, double rightPower) {
        frontLeftMotor.set(ControlMode.PercentOutput, leftPower);
        rearLeftMotor.set(ControlMode.PercentOutput, leftPower);
        frontRightMotor.set(ControlMode.PercentOutput, rightPower);
        rearRightMotor.set(ControlMode.PercentOutput, rightPower);
    }

    @Override
    public void periodic() {
    }
}
