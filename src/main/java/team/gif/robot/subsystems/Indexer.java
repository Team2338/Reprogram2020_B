package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Indexer extends SubsystemBase {

    private static Indexer instance = null;

    public static Indexer getInstance(){
        if(instance == null) {
            instance = new Indexer();
        }
        return instance;
    }
    /**
     * Creates a new ExampleSubsystem.
     */
    private static final VictorSPX stageTwoMotor = new VictorSPX(RobotMap.STAGE_TWO);
    private static final VictorSPX stageThreeMotor = new VictorSPX(RobotMap.STAGE_THREE);
    private static final VictorSPX stageFourMotor = new VictorSPX(RobotMap.STAGE_FOUR);
    private static final VictorSPX stageFiveMotor = new VictorSPX(RobotMap.STAGE_FIVE);


    public Indexer() {
        super();

        stageTwoMotor.setNeutralMode(NeutralMode.Brake);
        stageThreeMotor.setNeutralMode(NeutralMode.Brake);
        stageFourMotor.setNeutralMode(NeutralMode.Brake);
        stageFiveMotor.setNeutralMode(NeutralMode.Brake);

    }

    public void setSpeedTwo (double speed) {
        stageTwoMotor.set(ControlMode.PercentOutput, speed);
    }
    public void setSpeedThree (double speed) {
        stageThreeMotor.set(ControlMode.PercentOutput, speed);
    }
    public void setSpeedFour (double speed) {
        stageFourMotor.set(ControlMode.PercentOutput, speed);
    }
    public void setSpeedFive (double speed) {
        stageFiveMotor.set(ControlMode.PercentOutput, speed);
    }
}
