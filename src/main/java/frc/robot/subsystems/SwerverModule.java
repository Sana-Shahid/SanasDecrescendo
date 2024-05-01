// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;

/** Add your docs here. */
public class SwerverModule {


//2 neo motors with sparkmax motor controllers 
    private final CANSparkMax driveMotor;
    private final CANSparkMax turningMotor;
    

    //encoders value built into the neos 
    private final CANEncoder bdriveEncoder; 
    private final CANEncoder bturnEncoder;

    //encoder values that are from the spark max
    //???

    // stores the encoder values when the robot is powered off  
//    private final AnalogInput absoluteEncoder;

    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffset;



    //absolute encoder???

    public SwerveModule(int driverMotorId, int turnMotorId, boolean driveMotorReversed, boolean turningMotorReversed, int absoluteEncoderId ){
//        absoluteEncoder = new AnalogInput(absoluteEncoderId);

        driveMotor = new CANASparkMax(driveMotorId, MotorType.kBrushless);
        turningMotor = new CANSparkMax(turningMotorId, MotorType.kBrushless);

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turningMotorReversed);


        driverEncoder = driveMotor.getEncoder();
        turningEncoder = turningMotor.getEncoder();


        // THe original units of measuremeent for the encoders are in rotations and revollutions per minute thesemethods called are just to convert the values 
        driverEncoder.setPositionConverstionFactor(ModuleConstants.kDriveEncoderRot2Meter);
        driverEncoder.setVelocityConverstionFactor(ModulerConstatns.kDriveEnocderRPM2MeterPerSec);
        turningEncoder.setPostionConverstionFactor(ModuleConstants.kTurningEncoderRot2Meter);
        turningEncoder.setVelocityConverstionFactor(ModuleConstants.kTuringEncoderRPM2MeterPerSec);


        //initalzing the PID COntroller

      //  turningPidController = new PIDController(ModuleConstants.kPTurning, 0,0);




        // methods to help get encoder values (ig this is all anon)

        public double getDrivePosition(){
            return driverEncoder.getPosition();

        }
    }
}

