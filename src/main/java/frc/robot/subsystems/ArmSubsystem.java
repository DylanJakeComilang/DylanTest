package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
    private final CANSparkMax ArmMotor1 = new CANSparkMax(2, MotorType.kBrushless);
    private final CANSparkMax ArmMotor2 = new CANSparkMax(15, MotorType.kBrushless);
    RelativeEncoder relEnc;
    double pos = 50;

    public ArmSubsystem() {
        relEnc = ArmMotor2.getEncoder();
    }

    ////////////////////////
    ///      Methods     ///
    ////////////////////////

    // Encoder Methods

    public double getEncoder() {
        return relEnc.getPosition();
    }

    public void resetEncoder() {
        relEnc.setPosition(0);
    }
    
    // Auto Methods

    public void setForwards() {
        ArmMotor1.set(.5);
        ArmMotor2.set(.5);
    }

    public void setBackwards() {
        ArmMotor1.set(-.5);
        ArmMotor2.set(-.5);
    }

    // TeleOp

    public void setStop() {
        ArmMotor1.set(0);
        ArmMotor2.set(0);
    }

    public void setSpeed(double speed){
        ArmMotor1.set(speed);
        ArmMotor2.set(speed);
    }

    @Override
    public void periodic() {
    }
}
