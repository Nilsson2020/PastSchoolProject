public  class Array  implements IIntArray {

            int dataArray[];

            public Array() {

            }

            @Override
            public double getAverage() {
                if (dataArray.length == 0) {
                    throw new ArithmeticException("not_valid");
                }
                double summa = 0;
                for (int i = 0; i <dataArray.length; i++) {
                    summa = summa + dataArray[i];
                }

                double average = summa / dataArray.length;

                return average;
            }

            @Override
            public int[] findPositions(int val) throws NullPointerException {

                int langd = 0;

                for (int i = 0; i < dataArray.length; i++) {
                    if (dataArray[i] == val) {
                        langd++;
                    }
                }
                if (langd == 0) throw new NullPointerException("not_giltig");

                int[] NewArray = new int[langd];
                int x = 0;

                for (int l = 0; l < dataArray.length; l++) {
                    if (dataArray[l] == val) {
                        NewArray[x] = l;
                        x++;
                    }
                }
                return NewArray;
            }


            @Override
            public void appendLast(int value) throws ArithmeticException {
                if (dataArray.length == 0) throw new ArithmeticException("not_giltig");

                int[] NewArray = new int[dataArray.length + 1];

                for (int i = 0; i < dataArray.length; i++) {
                    NewArray[i] = dataArray[i];
                }
                NewArray[dataArray.length] = value;
                dataArray = NewArray;
            }


            @Override
            public void insertAt(int pos, int value)
                    throws ArrayIndexOutOfBoundsException {
                int[] NewArray;

                if (pos < 0) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    NewArray = new int[dataArray.length + 1];

                    for (int i = 0; i < NewArray.length; i++) {
                        if (i < pos)
                            NewArray[i] = dataArray[i];
                        else if (i == pos)
                            NewArray[i] = value;
                        else
                            NewArray[i] = dataArray[i - 1];
                    }
                }
                dataArray = NewArray;
            }


            @Override
            public int getAt(int pos) throws ArithmeticException {

                if (dataArray.length == 0) throw new ArithmeticException("not_valid");
                int varde = 0;


                for (int i = 0; i < dataArray.length; i++) {
                    if (pos == i) {
                        varde = dataArray[i];
                    }
                }
                return varde;
            }


            @Override
            public void setAt(int pos, int element) throws ArithmeticException {
                if (dataArray == null) {
                    throw new ArithmeticException("not_valid");
                }
                if (pos > dataArray.length || pos < 0) {
                    throw new ArithmeticException("not_valid");
                }

                for (int i = 0; i < dataArray.length; i++) {
                    if (pos == i) {
                        dataArray[i] = element;
                    }
                }
            }

            @Override
            public int deleteAt(int pos) throws anotherException, ArrayIndexOutOfBoundsException {

                int[] NewArray = new int[dataArray.length - 1];
                int delete = dataArray[pos];
                int k = 0;

                if (dataArray.length == 0) throw new ArithmeticException("Array is already empty, delete invalid");
                if (pos < 0 || pos > dataArray.length)
                    throw new ArrayIndexOutOfBoundsException("Positionen finns inte i arrayen");

                for (int i = 0; i <= pos - 1; i++) {
                    NewArray[k] = dataArray[i];
                    k++;
                }

                for (int i = pos + 1; i < dataArray.length; i++) {
                    NewArray[k] = dataArray[i];
                    k++;
                }
                dataArray = NewArray;

                return delete;
            }
}

