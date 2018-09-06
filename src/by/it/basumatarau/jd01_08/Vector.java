package by.it.basumatarau.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;
    public double[] getValue(){
        return this.value;
    }
    public Vector(String strVector){
        strVector=strVector.replace("{","").replace("}","");
        String[] strArray = strVector.split("(,\\s*)");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }
    public Vector(double[] value){
        this.value = new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = value[i];
        }
    }
    public Vector(Vector anotherVect){
        this.value = new double[anotherVect.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = anotherVect.value[i];
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Vector){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]+=((Vector) other).value[i];
            }
            return new Vector(result);
        } else if(other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]+=((Scalar)other).getVal();
            }
            return new Vector(result);
        } else {
            return other.add(this);
        }
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Vector){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]-= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else if(other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]-=((Scalar) other).getVal();
            }
            return new Vector(result);
        } else{
            return other.sub(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i]=this.value[i]*((Scalar) other).getVal();
            }
            return new Vector(result);
        }else if(other instanceof Vector){
            if(((Vector)other).value.length!=value.length){
                System.out.println("operation mul is not allowed for Vectors of different length");
                return null;
            } else {
                double result = 0;
                for (int i = 0; i < this.value.length; i++) {
                    result += this.value[i]*((Vector) other).value[i];
                }
                return new Scalar(result);
            }
        }else if(other instanceof Matrix){
            if(((Matrix) other).getValue()[0].length!=1){
                System.out.println("operation mul is not allowed for matrix and vector that have different amount of columns and rows (vector has only one row) respectively");
                return null;
            }
            double[][] result = new double[this.value.length][this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j]+=this.value[j]*((Matrix) other).getValue()[i][0];
                }
            }
            return new Matrix(result);
        }
        else{
            System.out.printf("operation mul is not allowed for %s and %s \n", getClass().getSimpleName(), other.getClass().getSimpleName());
            return null;
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                result[i]= this.value[i]/((Scalar)other).getVal();
            }
            return new Vector(result);
        } else {
            System.out.printf("operation div is not allowed for Vector and %s", other.getClass().getSimpleName());
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentVal : value) {
            result.append(delimiter).append(currentVal);
            delimiter=", ";
        }
        result.append("}");
        return result.toString();
    }
}
