package Data.round;

import Data.Data;

public enum MoveTo {
    left{

        @Override
        public int moveX() {
            return -1;
        }

        @Override
        public int moveY() {
            return 0;
        }
    },
    right{

        @Override
        public int moveX() {
            return 1;
        }

        @Override
        public int moveY() {
            return 0;
        }
    },
    up{

        @Override
        public int moveX() {
            return 0;
        }

        @Override
        public int moveY() {
            return -1;
        }
    },
    down{

        @Override
        public int moveX() {
            return 0;
        }

        @Override
        public int moveY() {
            return 1;
        }
    },
    leftUp{

        @Override
        public int moveX() {
            return -1;
        }

        @Override
        public int moveY() {
            return -1;
        }
    },
    rightUp{

        @Override
        public int moveX() {
            return 1;
        }

        @Override
        public int moveY() {
            return -1;
        }
    },
    leftDown{

        @Override
        public int moveX() {
            return -1;
        }

        @Override
        public int moveY() {
            return 1;
        }
    },
    rightDown{

        @Override
        public int moveX() {
            return 1;
        }

        @Override
        public int moveY() {
            return 1;
        }
    };

    abstract public int moveX();
    abstract public int moveY();
}
