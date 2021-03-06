package proj.zoie.api.impl.util;
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.IOException;

import org.apache.lucene.index.SegmentInfo;
import org.apache.lucene.index.SegmentInfos;
import org.apache.lucene.store.Directory;

public class IndexUtil {
	private IndexUtil()
	{	
	}
	
	public static int getNumSegments(Directory idx) throws IOException
	{
		SegmentInfos infos=new SegmentInfos();
		infos.read(idx);
		return infos.size();
	}
	public static String getSegmentsInfo(Directory idx)
	{
    SegmentInfos infos=new SegmentInfos();
    try
    {
      infos.read(idx);
      StringBuilder buf=new StringBuilder();
      for(int i=0;i<infos.size(); i++)
      {
    	SegmentInfo info = infos.info(i);
    	buf.append("[").append(info.name).append(",numDoc:").append(info.docCount).append(",numDel:").append(info.getDelCount()).append("]");
      }
      return buf.toString();
    } catch (Exception e)
    {
      return e.toString();
    }
	}
}
