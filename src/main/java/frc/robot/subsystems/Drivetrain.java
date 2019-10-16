package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.experimental.command.SendableSubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;
import java.util.function.Consumer;


public class Drivetrain extends SendableSubsystemBase {

    private CANSparkMax left1;
    private CANSparkMax left2;
    //private CANSparkMax left3;

    private CANSparkMax right1;
    private CANSparkMax right2;
    //private CANSparkMax right3;

    private SpeedControllerGroup left;
    private SpeedControllerGroup right;

    private DifferentialDrive drive;

    public static Drivetrain create() {
        return new Drivetrain();
    }

    public Drivetrain() {

        left1 = new CANSparkMax(RobotMap.left1CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);
        left2 = new CANSparkMax(RobotMap.left2CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);
        //left3 = new CANSparkMax(RobotMap.left3CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);
        right1 = new CANSparkMax(RobotMap.right1CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);
        right2 = new CANSparkMax(RobotMap.right2CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);
        //right3 = new CANSparkMax(RobotMap.right3CANDID, CANSparkMaxLowLevel.MotorType.kBrushless);

        left1.setInverted(false);
        left2.setInverted(true);
        //left3.setInverted(false);
        right1.setInverted(false);
        right2.setInverted(true);
        //right3.setInverted(false);
        
        left = new SpeedControllerGroup(left1, left2/*, left3*/);
        right = new SpeedControllerGroup(right1, right2/*, right3*/);
    
        drive = new DifferentialDrive(left, right);

        withEachMotor((m) -> m.setOpenLoopRampRate(0.5));

        setDefaultCommand(new TankDrive(this));

    }

    @Override
    public void periodic() {

    }
    
    private void withEachMotor(Consumer<CANSparkMax> fn) {
        fn.accept(left1);
        fn.accept(left2);
        //fn.accept(left3);
        fn.accept(right1);
        fn.accept(right2);
        //fn.accept(right3);
    }

    public void setPower(double leftpwr, double rightpwr) {
        leftpwr *= Constants.POWER_REDUCTION;
        rightpwr *= Constants.POWER_REDUCTION;
        drive.tankDrive(leftpwr, rightpwr, true);
    }

    public void stop(){
        setPower(0.0, 0.0);
    }

}

