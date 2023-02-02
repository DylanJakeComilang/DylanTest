package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends SubsystemBase {

    // Objects

    private final CANSparkMax elevatorMotor1 = new CANSparkMax(3,
            MotorType.kBrushless);
    private final CANSparkMax elevatorMotor2 = new CANSparkMax(6,
            MotorType.kBrushless);
    private final PIDController PID = new PIDController(0.07, 0.005, 0);
    private RelativeEncoder relEnc;
    private double errorPos = 0;
    private double errorVel = 0;

    public ElevatorSubsystem() {
        relEnc = elevatorMotor1.getEncoder();
        PID.setTolerance(0.1);
    }

    ///////////////////////////////         //  //  //////   //     // 
    ///         METHODS         ///         //////  //  //   // / //
    ///////////////////////////////         //  //  //////   // //

    // Encoder Methods

    public double getEncoder() {
        return relEnc.getPosition();
    }

    public void resetEncoder() {
        relEnc.setPosition(0);
    }

    // PID Methods

    public double calculateP(double setpoint) {
        double calc = PID.calculate(getEncoder(), setpoint);
        if (PID.atSetpoint()) {
            return 0;
        }
        if (calc > 1) {
            return 1;
        } else if (calc < -1) {
            return -1;
        } else {
            return calc;
        }
    }

    public void stopI() {
        double currentPos = PID.getPositionError();
        if (currentPos > 0 && errorPos < 0) {
            PID.reset();
        } else if (currentPos < 0 && errorPos > 0) {
            PID.reset();
        }
        errorPos = PID.getPositionError();
        SmartDashboard.putNumber("currentErrorPos", PID.getPositionError());
        SmartDashboard.putNumber("lastErrorPos", errorPos);
    }

    public void controlD(){
        double currentVel = PID.getVelocityError();

    }

    public void printP(double setpoint) {
        double calc = calculateP(setpoint);
        SmartDashboard.putNumber("elevator enc", getEncoder());
        SmartDashboard.putNumber("error", calc);
        SmartDashboard.putNumber("setpoint", setpoint);
        elevatorMotor1.set(calc);
        elevatorMotor2.set(calc);
        stopI();
    }

    // Teleop Methods

    public void setSpeed(double speed) {
        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }

    public void setStop() {
        elevatorMotor1.set(0);
        elevatorMotor2.set(0);
    }

    @Override
    public void periodic() {
    }

}