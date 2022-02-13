

class RotateBox {
	
	public char[][] rotateTheBox(char[][] box) {
		int rows = box.length;
		int cols = box[0].length;
	
		char[][] ans = new char[cols][rows];
	
		for (int i=0; i<box.length; i++) {
			int lastPos = box[0].length-1;
			for (int j=box[0].length-1; j>=0; j--) {
				if (box[i][j] == '*') {
					lastPos = j-1;
				}
				else if (box[i][j] == '#') {
					box[i][j] = '.';
					box[i][lastPos--]='#';
				}
			}
		}
	
		for (int j=0; j<cols; j++) {
			for (int i=rows-1; i>=0; i--) {
				ans[j][rows-1-i] = box[i][j];
			}
		}
	
		return ans;
    }	

}


