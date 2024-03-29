/*******************************************************************************************************************************
Pair.java

Copyright � 2021, Power Integrations Corporation. All rights reserved.
The Programs (which include both the software and documentation) contain proprietary information of Power Integrations Corporation;
they are provided under a license agreement containing restrictions on use and disclosure and are also protected by
copyright, patent and other intellectual and industrial property law. Reverse engineering, disassembly or de-compilation of
the programs is prohibited.
Program Documentation is licensed for use solely to support the deployment of the Programs and not for any other
purpose.
The information contained in this document is subject to change without notice. If you find any problems in the
documentation, please report them to us in writing. Power Integrations Corporation does not warrant that this document is error free.
Except as may be expressly permitted in your license agreement for these Programs, no part of these Programs may be
reproduced or transmitted in any form or by any means, electronic or mechanical, for any purpose, without the express
written permission of Power Integrations Corporation.

Author : ymohammad
Date   : Jul 23, 2021

Last modified by : ymohammad
Last modified on : Jul 23, 2021

*******************************************************************************************************************************/

package com.alysoft.completedsa.graph;

/**
* Class Pair
*/
public class Pair {
    
    public int node;
    public String psf;
    public int level;
    
    public Pair(int node, String psf, int level) {
	this.node = node;
	this.psf = psf;
	this.level = level;
    }
}
