package frc.robot.subsystems;                                        

import edu.wpi.first.wpilibj2.command.SubsystemBase;                                        
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;        

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;                                        
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;                                        

public class DriveSubsystem extends SubsystemBase {                                        
    /* 
    private final CANSparkMax frontLeft = new CANSparkMax(6, MotorType.kBrushless);                                         
    private final CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);                                        
    private final CANSparkMax backLeft = new CANSparkMax(3, MotorType.kBrushless);                                        
    private final CANSparkMax backRight = new CANSparkMax(15, MotorType.kBrushless);                                        
    private final MotorControllerGroup leftSide = new MotorControllerGroup(frontLeft, backLeft);                                        
    private final MotorControllerGroup rightSide = new MotorControllerGroup(frontRight, backRight);                                        
    private final DifferentialDrive differ = new DifferentialDrive(backRight, backLeft);
    private final double speed = 0.1;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    public DriveSubsystem() {
    }

    public double deadZone(double deadBand) { //slight movements on joystick don't set motors
        if (Math.abs(deadBand) < 0.1) {
            return 0;
        } else {
            return deadBand;
        }
    }

    // encoder

    public double getLeftEncoder() {
        return leftEncoder.getPosition();
    }

    public double getRightEncoder(){
        return rightEncoder.getPosition();
    }

    // teleOp

    public void setTank(double leftSpeed, double rightSpeed) { //sets the tank drive
        differ.tankDrive(-leftSpeed, rightSpeed);
    }

    public void setArcade(double xSpeed, double zSpeed){ //sets the arcade drive
        differ.arcadeDrive(xSpeed, zSpeed);
    }

    // autonomous

    public void forwards(){
        leftSide.set(speed);
        rightSide.set(speed);
    }

    public void backwards(){
        leftSide.set(-speed);
        rightSide.set(-speed);
    }

    public void turnLeft(){
        leftSide.set(-speed);
        rightSide.set(speed);
    }

    public void turnRight(){
        leftSide.set(speed);
        rightSide.set(-speed);
    }
    @Override
    public void periodic() {

        SmartDashboard.putNumber("Left Encoder", getLeftEncoder());
        SmartDashboard.putNumber("Right Encoder", getRightEncoder());
    } 
    */
}
