package com.wqp.aiot.edge.stream.stream.protof;// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stream_transfer_data.proto

public final class StreamTransferProtof {
  private StreamTransferProtof() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface StreamTransferDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:StreamTransferData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 传输时间(开始)
     * </pre>
     *
     * <code>string transfertime = 100;</code>
     */
    String getTransfertime();
    /**
     * <pre>
     * 传输时间(开始)
     * </pre>
     *
     * <code>string transfertime = 100;</code>
     */
    com.google.protobuf.ByteString
        getTransfertimeBytes();

    /**
     * <pre>
     * 边缘设备唯一标识
     * </pre>
     *
     * <code>string edgeid = 101;</code>
     */
    String getEdgeid();
    /**
     * <pre>
     * 边缘设备唯一标识
     * </pre>
     *
     * <code>string edgeid = 101;</code>
     */
    com.google.protobuf.ByteString
        getEdgeidBytes();

    /**
     * <pre>
     * 源数据
     * </pre>
     *
     * <code>string origindata = 102;</code>
     */
    String getOrigindata();
    /**
     * <pre>
     * 源数据
     * </pre>
     *
     * <code>string origindata = 102;</code>
     */
    com.google.protobuf.ByteString
        getOrigindataBytes();

    /**
     * <pre>
     * 源数据名称
     * </pre>
     *
     * <code>string originname = 103;</code>
     */
    String getOriginname();
    /**
     * <pre>
     * 源数据名称
     * </pre>
     *
     * <code>string originname = 103;</code>
     */
    com.google.protobuf.ByteString
        getOriginnameBytes();

    /**
     * <pre>
     * 源数据主题
     * </pre>
     *
     * <code>string origintopic = 104;</code>
     */
    String getOrigintopic();
    /**
     * <pre>
     * 源数据主题
     * </pre>
     *
     * <code>string origintopic = 104;</code>
     */
    com.google.protobuf.ByteString
        getOrigintopicBytes();
  }
  /**
   * Protobuf type {@code StreamTransferData}
   */
  public  static final class StreamTransferData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:StreamTransferData)
      StreamTransferDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use StreamTransferData.newBuilder() to construct.
    private StreamTransferData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private StreamTransferData() {
      transfertime_ = "";
      edgeid_ = "";
      origindata_ = "";
      originname_ = "";
      origintopic_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
        UnusedPrivateParameter unused) {
      return new StreamTransferData();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private StreamTransferData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 802: {
              String s = input.readStringRequireUtf8();

              transfertime_ = s;
              break;
            }
            case 810: {
              String s = input.readStringRequireUtf8();

              edgeid_ = s;
              break;
            }
            case 818: {
              String s = input.readStringRequireUtf8();

              origindata_ = s;
              break;
            }
            case 826: {
              String s = input.readStringRequireUtf8();

              originname_ = s;
              break;
            }
            case 834: {
              String s = input.readStringRequireUtf8();

              origintopic_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return StreamTransferProtof.internal_static_StreamTransferData_descriptor;
    }

    @Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return StreamTransferProtof.internal_static_StreamTransferData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StreamTransferData.class, Builder.class);
    }

    public static final int TRANSFERTIME_FIELD_NUMBER = 100;
    private volatile Object transfertime_;
    /**
     * <pre>
     * 传输时间(开始)
     * </pre>
     *
     * <code>string transfertime = 100;</code>
     */
    public String getTransfertime() {
      Object ref = transfertime_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        transfertime_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 传输时间(开始)
     * </pre>
     *
     * <code>string transfertime = 100;</code>
     */
    public com.google.protobuf.ByteString
        getTransfertimeBytes() {
      Object ref = transfertime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        transfertime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int EDGEID_FIELD_NUMBER = 101;
    private volatile Object edgeid_;
    /**
     * <pre>
     * 边缘设备唯一标识
     * </pre>
     *
     * <code>string edgeid = 101;</code>
     */
    public String getEdgeid() {
      Object ref = edgeid_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        edgeid_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 边缘设备唯一标识
     * </pre>
     *
     * <code>string edgeid = 101;</code>
     */
    public com.google.protobuf.ByteString
        getEdgeidBytes() {
      Object ref = edgeid_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        edgeid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ORIGINDATA_FIELD_NUMBER = 102;
    private volatile Object origindata_;
    /**
     * <pre>
     * 源数据
     * </pre>
     *
     * <code>string origindata = 102;</code>
     */
    public String getOrigindata() {
      Object ref = origindata_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        origindata_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 源数据
     * </pre>
     *
     * <code>string origindata = 102;</code>
     */
    public com.google.protobuf.ByteString
        getOrigindataBytes() {
      Object ref = origindata_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        origindata_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ORIGINNAME_FIELD_NUMBER = 103;
    private volatile Object originname_;
    /**
     * <pre>
     * 源数据名称
     * </pre>
     *
     * <code>string originname = 103;</code>
     */
    public String getOriginname() {
      Object ref = originname_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        originname_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 源数据名称
     * </pre>
     *
     * <code>string originname = 103;</code>
     */
    public com.google.protobuf.ByteString
        getOriginnameBytes() {
      Object ref = originname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        originname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ORIGINTOPIC_FIELD_NUMBER = 104;
    private volatile Object origintopic_;
    /**
     * <pre>
     * 源数据主题
     * </pre>
     *
     * <code>string origintopic = 104;</code>
     */
    public String getOrigintopic() {
      Object ref = origintopic_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        origintopic_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 源数据主题
     * </pre>
     *
     * <code>string origintopic = 104;</code>
     */
    public com.google.protobuf.ByteString
        getOrigintopicBytes() {
      Object ref = origintopic_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        origintopic_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getTransfertimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 100, transfertime_);
      }
      if (!getEdgeidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 101, edgeid_);
      }
      if (!getOrigindataBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 102, origindata_);
      }
      if (!getOriginnameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 103, originname_);
      }
      if (!getOrigintopicBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 104, origintopic_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTransfertimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(100, transfertime_);
      }
      if (!getEdgeidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(101, edgeid_);
      }
      if (!getOrigindataBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(102, origindata_);
      }
      if (!getOriginnameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(103, originname_);
      }
      if (!getOrigintopicBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(104, origintopic_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof StreamTransferData)) {
        return super.equals(obj);
      }
      StreamTransferData other = (StreamTransferData) obj;

      if (!getTransfertime()
          .equals(other.getTransfertime())) return false;
      if (!getEdgeid()
          .equals(other.getEdgeid())) return false;
      if (!getOrigindata()
          .equals(other.getOrigindata())) return false;
      if (!getOriginname()
          .equals(other.getOriginname())) return false;
      if (!getOrigintopic()
          .equals(other.getOrigintopic())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TRANSFERTIME_FIELD_NUMBER;
      hash = (53 * hash) + getTransfertime().hashCode();
      hash = (37 * hash) + EDGEID_FIELD_NUMBER;
      hash = (53 * hash) + getEdgeid().hashCode();
      hash = (37 * hash) + ORIGINDATA_FIELD_NUMBER;
      hash = (53 * hash) + getOrigindata().hashCode();
      hash = (37 * hash) + ORIGINNAME_FIELD_NUMBER;
      hash = (53 * hash) + getOriginname().hashCode();
      hash = (37 * hash) + ORIGINTOPIC_FIELD_NUMBER;
      hash = (53 * hash) + getOrigintopic().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static StreamTransferData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StreamTransferData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StreamTransferData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StreamTransferData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StreamTransferData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static StreamTransferData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static StreamTransferData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StreamTransferData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static StreamTransferData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static StreamTransferData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static StreamTransferData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static StreamTransferData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(StreamTransferData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code StreamTransferData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:StreamTransferData)
        StreamTransferDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return StreamTransferProtof.internal_static_StreamTransferData_descriptor;
      }

      @Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return StreamTransferProtof.internal_static_StreamTransferData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                StreamTransferData.class, Builder.class);
      }

      // Construct using StreamTransferProtof.StreamTransferData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        transfertime_ = "";

        edgeid_ = "";

        origindata_ = "";

        originname_ = "";

        origintopic_ = "";

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return StreamTransferProtof.internal_static_StreamTransferData_descriptor;
      }

      @Override
      public StreamTransferData getDefaultInstanceForType() {
        return StreamTransferData.getDefaultInstance();
      }

      @Override
      public StreamTransferData build() {
        StreamTransferData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public StreamTransferData buildPartial() {
        StreamTransferData result = new StreamTransferData(this);
        result.transfertime_ = transfertime_;
        result.edgeid_ = edgeid_;
        result.origindata_ = origindata_;
        result.originname_ = originname_;
        result.origintopic_ = origintopic_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof StreamTransferData) {
          return mergeFrom((StreamTransferData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(StreamTransferData other) {
        if (other == StreamTransferData.getDefaultInstance()) return this;
        if (!other.getTransfertime().isEmpty()) {
          transfertime_ = other.transfertime_;
          onChanged();
        }
        if (!other.getEdgeid().isEmpty()) {
          edgeid_ = other.edgeid_;
          onChanged();
        }
        if (!other.getOrigindata().isEmpty()) {
          origindata_ = other.origindata_;
          onChanged();
        }
        if (!other.getOriginname().isEmpty()) {
          originname_ = other.originname_;
          onChanged();
        }
        if (!other.getOrigintopic().isEmpty()) {
          origintopic_ = other.origintopic_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        StreamTransferData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (StreamTransferData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object transfertime_ = "";
      /**
       * <pre>
       * 传输时间(开始)
       * </pre>
       *
       * <code>string transfertime = 100;</code>
       */
      public String getTransfertime() {
        Object ref = transfertime_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          transfertime_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 传输时间(开始)
       * </pre>
       *
       * <code>string transfertime = 100;</code>
       */
      public com.google.protobuf.ByteString
          getTransfertimeBytes() {
        Object ref = transfertime_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          transfertime_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 传输时间(开始)
       * </pre>
       *
       * <code>string transfertime = 100;</code>
       */
      public Builder setTransfertime(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        transfertime_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 传输时间(开始)
       * </pre>
       *
       * <code>string transfertime = 100;</code>
       */
      public Builder clearTransfertime() {
        
        transfertime_ = getDefaultInstance().getTransfertime();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 传输时间(开始)
       * </pre>
       *
       * <code>string transfertime = 100;</code>
       */
      public Builder setTransfertimeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        transfertime_ = value;
        onChanged();
        return this;
      }

      private Object edgeid_ = "";
      /**
       * <pre>
       * 边缘设备唯一标识
       * </pre>
       *
       * <code>string edgeid = 101;</code>
       */
      public String getEdgeid() {
        Object ref = edgeid_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          edgeid_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 边缘设备唯一标识
       * </pre>
       *
       * <code>string edgeid = 101;</code>
       */
      public com.google.protobuf.ByteString
          getEdgeidBytes() {
        Object ref = edgeid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          edgeid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 边缘设备唯一标识
       * </pre>
       *
       * <code>string edgeid = 101;</code>
       */
      public Builder setEdgeid(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        edgeid_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 边缘设备唯一标识
       * </pre>
       *
       * <code>string edgeid = 101;</code>
       */
      public Builder clearEdgeid() {
        
        edgeid_ = getDefaultInstance().getEdgeid();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 边缘设备唯一标识
       * </pre>
       *
       * <code>string edgeid = 101;</code>
       */
      public Builder setEdgeidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        edgeid_ = value;
        onChanged();
        return this;
      }

      private Object origindata_ = "";
      /**
       * <pre>
       * 源数据
       * </pre>
       *
       * <code>string origindata = 102;</code>
       */
      public String getOrigindata() {
        Object ref = origindata_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          origindata_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 源数据
       * </pre>
       *
       * <code>string origindata = 102;</code>
       */
      public com.google.protobuf.ByteString
          getOrigindataBytes() {
        Object ref = origindata_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          origindata_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 源数据
       * </pre>
       *
       * <code>string origindata = 102;</code>
       */
      public Builder setOrigindata(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        origindata_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据
       * </pre>
       *
       * <code>string origindata = 102;</code>
       */
      public Builder clearOrigindata() {
        
        origindata_ = getDefaultInstance().getOrigindata();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据
       * </pre>
       *
       * <code>string origindata = 102;</code>
       */
      public Builder setOrigindataBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        origindata_ = value;
        onChanged();
        return this;
      }

      private Object originname_ = "";
      /**
       * <pre>
       * 源数据名称
       * </pre>
       *
       * <code>string originname = 103;</code>
       */
      public String getOriginname() {
        Object ref = originname_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          originname_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 源数据名称
       * </pre>
       *
       * <code>string originname = 103;</code>
       */
      public com.google.protobuf.ByteString
          getOriginnameBytes() {
        Object ref = originname_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          originname_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 源数据名称
       * </pre>
       *
       * <code>string originname = 103;</code>
       */
      public Builder setOriginname(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        originname_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据名称
       * </pre>
       *
       * <code>string originname = 103;</code>
       */
      public Builder clearOriginname() {
        
        originname_ = getDefaultInstance().getOriginname();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据名称
       * </pre>
       *
       * <code>string originname = 103;</code>
       */
      public Builder setOriginnameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        originname_ = value;
        onChanged();
        return this;
      }

      private Object origintopic_ = "";
      /**
       * <pre>
       * 源数据主题
       * </pre>
       *
       * <code>string origintopic = 104;</code>
       */
      public String getOrigintopic() {
        Object ref = origintopic_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          origintopic_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <pre>
       * 源数据主题
       * </pre>
       *
       * <code>string origintopic = 104;</code>
       */
      public com.google.protobuf.ByteString
          getOrigintopicBytes() {
        Object ref = origintopic_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          origintopic_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 源数据主题
       * </pre>
       *
       * <code>string origintopic = 104;</code>
       */
      public Builder setOrigintopic(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        origintopic_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据主题
       * </pre>
       *
       * <code>string origintopic = 104;</code>
       */
      public Builder clearOrigintopic() {
        
        origintopic_ = getDefaultInstance().getOrigintopic();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 源数据主题
       * </pre>
       *
       * <code>string origintopic = 104;</code>
       */
      public Builder setOrigintopicBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        origintopic_ = value;
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:StreamTransferData)
    }

    // @@protoc_insertion_point(class_scope:StreamTransferData)
    private static final StreamTransferData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new StreamTransferData();
    }

    public static StreamTransferData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<StreamTransferData>
        PARSER = new com.google.protobuf.AbstractParser<StreamTransferData>() {
      @Override
      public StreamTransferData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new StreamTransferData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<StreamTransferData> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<StreamTransferData> getParserForType() {
      return PARSER;
    }

    @Override
    public StreamTransferData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StreamTransferData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StreamTransferData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\032stream_transfer_data.proto\"w\n\022StreamTr" +
      "ansferData\022\024\n\014transfertime\030d \001(\t\022\016\n\006edge" +
      "id\030e \001(\t\022\022\n\norigindata\030f \001(\t\022\022\n\noriginna" +
      "me\030g \001(\t\022\023\n\013origintopic\030h \001(\tB\026B\024StreamT" +
      "ransferProtofb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_StreamTransferData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_StreamTransferData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StreamTransferData_descriptor,
        new String[] { "Transfertime", "Edgeid", "Origindata", "Originname", "Origintopic", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
